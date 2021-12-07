package pl.bdaf.medical_center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bdaf.medical_center.entity.Consent;
import pl.bdaf.medical_center.repository.ConsentRepository;

import java.util.List;

@Service
public class ConsentServiceImpl implements ConsentService {

    @Autowired
    private ConsentRepository consentRepository;

    @Override
    public List<Consent> getAllConsents() {
        return consentRepository.findAll();
    }

    @Override
    public Consent getConsentById(Long aConsentId) {
        return consentRepository.findById(aConsentId).get();
    }

    @Override
    public Consent saveConsent(Consent aConsent) {
        Consent save = consentRepository.save(aConsent);
        return save;
    }

    @Override
    public void deleteById(Long aConsentId) {
        consentRepository.deleteById(aConsentId);
    }

    @Override
    public Consent setConnection(Long aConsentId, Boolean aIsConnected) {
        Consent consentToUpdate = consentRepository.findById(aConsentId).get();
        consentToUpdate.setIsConnected(aIsConnected);
        return consentRepository.save(consentToUpdate);
    }
}
