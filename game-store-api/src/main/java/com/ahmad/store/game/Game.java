package com.ahmad.store.game;

import com.ahmad.store.category.Category;
import com.ahmad.store.commen.BaseEntity;
import com.ahmad.store.comment.Comment;
import com.ahmad.store.whishlist.WishList;
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
public class Game extends BaseEntity {

    private String title;

    @Enumerated(EnumType.STRING)
    private SupportedPlatforms supportedPlatforms;

    private String coveredPicture;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "game")
    private List<Comment> comments;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "game_wishlist",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "wishlist_id")
    )
    private List<WishList> wishLists;


    public void addWishList(WishList wishList) {
        this.wishLists.add(wishList);
        wishList.getGames().add(this);
    }

    public void removeWishList(WishList wishList) {
        this.wishLists.remove(wishList);
        wishList.getGames().remove(this);
    }


}
