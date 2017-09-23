package nl.hu.curcon.service.impl;

import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.dtomapper.Dto2DomainMapper;

import org.springframework.beans.factory.annotation.Autowired;

public class GenericService {

    @Autowired
    protected Domain2DtoMapper domain2DtoMapper;

    @Autowired
    protected Dto2DomainMapper dto2DomainMapper;
}
