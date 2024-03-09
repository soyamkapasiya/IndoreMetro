package com.kapasiya.indoremetro.serviceimpl;

import com.kapasiya.indoremetro.entity.LAFData;
import com.kapasiya.indoremetro.repository.LAFRepository;
import com.kapasiya.indoremetro.servicedef.LAFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LAFServiceImpl implements LAFService
{

    @Autowired
    LAFRepository lafRepository;
    @Override
    public List<LAFData> getAllLAFData()
    {
        return lafRepository.findAll();
    }

    @Override
    public void addLAFData(LAFData data)
    {
        lafRepository.save(data);
    }
}
