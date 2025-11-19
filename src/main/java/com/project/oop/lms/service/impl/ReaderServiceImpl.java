package com.project.oop.lms.service.impl;

import com.project.oop.lms.entity.DocGia;
import com.project.oop.lms.service.IReaderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements IReaderService {
    @Override
    public List<DocGia> getAllDocGia() {
        return List.of();
    }

    @Override
    public void themDocGia() {

    }

    @Override
    public void thayDoiThongTinDocGia() {

    }

    @Override
    public void xoaDocGia() {

    }
}
