package com.example.IndividualTrackProject.Service.Interfaces;

import com.example.IndividualTrackProject.Model.Admin;

import java.util.List;

public interface IAdminService {
    Boolean createAdmin(Admin admin);
    List<Admin> getAllAdmins();
}
