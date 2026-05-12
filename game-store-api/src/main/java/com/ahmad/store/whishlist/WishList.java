package com.ahmad.store.whishlist;

import com.ahmad.store.commen.BaseEntity;
import com.ahmad.store.game.Game;
import com.ahmad.store.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WishList extends BaseEntity {

    private String name;

    @OneToOne
    private User user;

    @ManyToMany(mappedBy = "wishLists",fetch = FetchType.EAGER)
    private List<Game> games;
}
