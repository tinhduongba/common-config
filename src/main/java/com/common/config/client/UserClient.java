package com.common.config.client;

import com.common.config.model.ResModel;
import com.common.config.model.user.CompanyDTO;
import com.common.config.model.user.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "user-service")
public interface UserClient {
    @GetMapping("/user/users/{id}")
    ResModel<UserDTO> getUserById(@PathVariable("id") UUID id);

    @GetMapping("/user/users/all")
    ResModel<List<UserDTO>> getUserByIds(@RequestParam("ids") List<UUID> ids);

    @GetMapping("/user/users/email/{email}")
    ResModel<UserDTO> getUserByEmail(@PathVariable("email") String email);

    @GetMapping("/user/companies/list")
    ResModel<List<CompanyDTO>> getAllCompanies(@RequestParam("ids") List<UUID> ids);
}
