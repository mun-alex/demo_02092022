package kz.bitlab.demo.services;

import kz.bitlab.demo.models.Publishing;

import java.util.List;

public interface PublishingService {
    List<Publishing> getAllPublishings();
    void addPublishing(Publishing publishing);
    Publishing getPublishingById(Long id);
    void updatePublishing(Publishing publishing);
    void deletePublishingById(Long id);
}
