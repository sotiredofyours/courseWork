package domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Book {
     Integer id;
     String title;
     String author;
     Integer quantity;
}
