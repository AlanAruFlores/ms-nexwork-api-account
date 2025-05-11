package com.nexwork.api.account.ms_nexwork_api_account.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.nexwork.api.account.ms_nexwork_api_account.models.CompanyTypeEntity;
import com.nexwork.api.account.ms_nexwork_api_account.models.GeolocationEntity;
import com.nexwork.api.account.ms_nexwork_api_account.models.SupplierCompanyEntity;
import com.nexwork.api.account.ms_nexwork_api_account.models.WorkerEntity;
import com.nexwork.api.account.ms_nexwork_api_account.persistence.repository.CompanyTypeRepository;
import com.nexwork.api.account.ms_nexwork_api_account.persistence.repository.GeolocationRepository;
import com.nexwork.api.account.ms_nexwork_api_account.persistence.repository.SupplierCompanyRepository;
import com.nexwork.api.account.ms_nexwork_api_account.persistence.repository.WorkerRepository;
import com.nexwork.api.account.ms_nexwork_api_account.utils.CompanyTypeDataHelper;
import com.nexwork.api.account.ms_nexwork_api_account.utils.GeolocationDataHelper;
import com.nexwork.api.account.ms_nexwork_api_account.utils.SupplierCompanyHelper;
import com.nexwork.api.account.ms_nexwork_api_account.utils.WorkerDataHelper;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final CompanyTypeRepository companyTypeRepository;
    private final SupplierCompanyRepository supplierCompanyRepository;
    private final GeolocationRepository geolocationRepository;
    private final WorkerRepository workerRepository;

    @Override
    public void run(String... args) throws Exception {
        

        //Inicializar datos de los tipos de compañia
        List<CompanyTypeEntity> companyTypes = CompanyTypeDataHelper.getCompanyTypes();
        companyTypeRepository.saveAll(companyTypes);

        //Inicializar Geolocaciones de compañia
        List<GeolocationEntity> geolocations = GeolocationDataHelper.getGeolocations();
        geolocationRepository.saveAll(geolocations);




        //Inicializar entidades de proveedores
        List<SupplierCompanyEntity> suppliers = SupplierCompanyHelper.getSupplierCompanies();
        
        suppliers.get(0).setCompanyType(companyTypeRepository.findByName("Limpieza e Higiene Industrial").get());            
        suppliers.get(0).setGeolocation(geolocationRepository.findById(1L).get());
        
        suppliers.get(1).setCompanyType(companyTypeRepository.findByName("Tecnología y Software").get());
        suppliers.get(1).setGeolocation(geolocationRepository.findById(2L).get());
        
        suppliers.get(2).setCompanyType(companyTypeRepository.findByName("Agroindustria").get());
        suppliers.get(2).setGeolocation(geolocationRepository.findById(3L).get());    

        supplierCompanyRepository.saveAll(suppliers);

        //Inicializar datos de workers
        List<WorkerEntity> workers = WorkerDataHelper.getWorkers();
        
        workers.get(0).setCompany(suppliers.get(0)); // Juan Pérez - Arrteh
        workers.get(1).setCompany(suppliers.get(0)); // María García - Arrteh
        workers.get(2).setCompany(suppliers.get(1)); // Carlos Rodríguez - TechSolutions
        workers.get(3).setCompany(suppliers.get(1)); // Ana Martínez - TechSolutions
        workers.get(4).setCompany(suppliers.get(2)); // Roberto López - AgroFertil
        workers.get(5).setCompany(suppliers.get(2)); // Laura Sánchez - AgroFertil
        
        workerRepository.saveAll(workers);

        log.info("Data initialized successfully");


    }
}