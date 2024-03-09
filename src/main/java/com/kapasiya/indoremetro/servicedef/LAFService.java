package com.kapasiya.indoremetro.servicedef;

import com.kapasiya.indoremetro.entity.LAFData;

import java.util.List;


public interface LAFService
{
    public List<LAFData> getAllLAFData();

    public void addLAFData(LAFData data);
}
