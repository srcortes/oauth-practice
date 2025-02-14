package com.products.domain.mapper;

import com.products.domain.aggregate.User;
import com.products.infrastructure.entities.AuthorityEntity;
import com.products.infrastructure.entities.EncryptionEntity;
import com.products.infrastructure.entities.UserEntity;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


@Mapper()
public interface UserMapper {
  @Mapping(source = "algorithm", target = "algorithm", qualifiedByName = "mapEncryption")
  @Mapping(source = "authorities", target = "authorities", qualifiedByName = "mapAuthorities")
  User toDTO(UserEntity user);

  @Named("mapEncryption")
  default String mapEncryption(EncryptionEntity encryption) {
    return encryption != null ? encryption.name() : null;
  }

  @Named("mapAuthorities")
  default List<String> mapAuthorities(List<AuthorityEntity> authorities) {
    return authorities != null ?
        authorities.stream().map(AuthorityEntity::getName).collect(Collectors.toList())
        : Collections.emptyList();
  }

}
