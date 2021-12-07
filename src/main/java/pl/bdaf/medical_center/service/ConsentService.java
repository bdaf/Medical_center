package pl.bdaf.medical_center.service;

import pl.bdaf.medical_center.entity.Consent;

import java.util.List;

public interface ConsentService {
    List<Consent> getAllConsents();

    Consent getConsentById(Long aConsentId);

    Consent saveConsent(Consent aConsent);

    void deleteById(Long aConsentId);

    Consent setConnection(Long aConsentId, Boolean aIsConnected);
}
