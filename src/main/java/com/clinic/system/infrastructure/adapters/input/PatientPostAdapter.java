package com.clinic.system.infrastructure.adapters.input;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.clinic.system.application.PatientCreator;
import com.clinic.system.application.PatientCreatorCommand;
import com.clinic.system.application.PatientCreatorResult;

@RestController
@RequestMapping("api/patients")
@Validated
public class PatientPostAdapter {

    private PatientCreator useCase;
    private PatientPostAdapterMapper adapterMapper;

    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<PatientPostAdapterResponse> postGuest(
            @RequestParam("uuid") String uuid,
            @RequestParam("lastname") String lastname,
            @RequestParam("name") String name,
            @RequestPart(value = "photo", required = false) MultipartFile photo) throws Exception {
        PatientPostAdapterRequest req = new PatientPostAdapterRequest();
        req.setUuid(uuid);
        req.setLastname(lastname);
        req.setName(name);
        req.setFoto(photo);

        byte[] fotoBytes = null;
        String filename = null;
        if (photo != null && !photo.isEmpty()) {
            fotoBytes = photo.getBytes();
            filename = photo.getOriginalFilename();
        }

        PatientCreatorCommand command = adapterMapper.toCommand(req);
        PatientCreatorResult result = useCase.perform(command);

        return ResponseEntity.ok(PatientPostAdapterResponse.builder().uuid(result.getUuid()).build());
    }

}
