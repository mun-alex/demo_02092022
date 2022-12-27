package kz.bitlab.demo.services.impl;

import kz.bitlab.demo.models.Publishing;
import kz.bitlab.demo.repositories.PublishingRepository;
import kz.bitlab.demo.services.PublishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishingServiceImpl implements PublishingService {

    @Autowired
    private PublishingRepository publishingRepository;
    @Override
    public List<Publishing> getAllPublishings() {
        return publishingRepository.findAll();
    }

    @Override
    public void addPublishing(Publishing publishing) {
        publishingRepository.save(publishing);
    }

    @Override
    public Publishing getPublishingById(Long id) {
        return publishingRepository.findById(id).orElseThrow();
    }

    @Override
    public void updatePublishing(Publishing publishing) {
        publishingRepository.save(publishing);
    }

    @Override
    public void deletePublishingById(Long id) {
        publishingRepository.deleteById(id);
    }
}
