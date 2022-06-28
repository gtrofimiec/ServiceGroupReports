package com.gtrofimiec.servicegroupreports.backend.mapper;

import com.gtrofimiec.servicegroupreports.backend.domain.Publisher;
import com.gtrofimiec.servicegroupreports.backend.domain.dto.PublisherDto;
import com.gtrofimiec.servicegroupreports.exception.PublisherNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherMapper {

    public Publisher mapToPublisher(final @NotNull PublisherDto publisherDto) throws PublisherNotFoundException {
        return new Publisher(
                publisherDto.getId(),
                publisherDto.getName(),
                publisherDto.getSurname(),
                publisherDto.getGroup(),
                publisherDto.getPrivilege(),
                publisherDto.getStatus(),
                publisherDto.isDeleted()
        );
    }

    public PublisherDto mapToPublisherDto(final @NotNull Publisher publisher) throws PublisherNotFoundException {
        return new PublisherDto(
                publisher.getId(),
                publisher.getName(),
                publisher.getSurname(),
                publisher.getGroup(),
                publisher.getPrivilege(),
                publisher.getStatus(),
                publisher.isDeleted()
        );
    }

    public List<PublisherDto> mapToPublisherDtoList(final @NotNull List<Publisher> publisherList) {
        return publisherList.stream()
                .map(this::mapToPublisherDto)
                .collect(Collectors.toList());
    }
}