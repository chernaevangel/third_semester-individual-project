package com.example.IndividualTrackProject.Service;

import com.example.IndividualTrackProject.Model.Admin;
import com.example.IndividualTrackProject.Service.Interfaces.IAdminService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminService implements IAdminService {
    
    @Override
    public Boolean createAdmin(Admin admin) {
        return null;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return null;
    }
}
