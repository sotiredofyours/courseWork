package domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Book {
     Integer id;
     String title;
     String author;
     Integer quantity;
}
