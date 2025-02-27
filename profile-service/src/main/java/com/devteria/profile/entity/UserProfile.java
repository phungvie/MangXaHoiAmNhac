package com.devteria.profile.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
// @Node("user_profile")
public class UserProfile {
    @Id
    @GeneratedValue(generatorClass = UUIDStringGenerator.class)
    String id;

    @Property("userId")
    String userId;

    String username;
    String email;
    String stageName;
    String firstName;
    String lastName;
    LocalDate dob;
    String city;
    String img;
    // Mối quan hệ theo dõi người dùng
    @Relationship(type = "FOLLOWS", direction = Relationship.Direction.OUTGOING)
    Set<UserProfile> following;

    @CreatedDate
    Instant createdDate;

    @LastModifiedDate
    Instant modifiedDate;
}
