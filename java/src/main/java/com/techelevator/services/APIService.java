package com.techelevator.services;

import com.techelevator.model.RecordDTO;

public interface APIService {

    RecordDTO getRecordInformation(String recordId);
}
