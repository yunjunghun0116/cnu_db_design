package com.junghun.con.domain.like.entity;

import com.junghun.con.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "like_store")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LikeStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "store_id")
    private Long storeId;
}