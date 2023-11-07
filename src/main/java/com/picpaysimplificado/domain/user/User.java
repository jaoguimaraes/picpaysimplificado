package com.picpaysimplificado.domain.user;

import com.picpaysimplificado.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "users")//Esta classe será uma entidade no banco de dados, por isso o Entity
@Table(name = "users")//Criação de fato da tabela entidade
@Getter
@Setter
@AllArgsConstructor //Construtor que recebe os parametros da classe
@NoArgsConstructor //Para não ser obrigatório um construtor na classe
@EqualsAndHashCode(of = "id") //Para setar a chave primaria desta tabela
public class User {
    @Id //1º campo, ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Setando como será a geração, neste caso, de forma incremental
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)//Notação para setar que esta precisa ser uma informação única
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING) //Para dizer que este cara representa um dos usuários (user real ou lojista)
    private UserType userType;

    public User(final UserDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.balance = data.balance();
        this.userType = data.userType();
        this.password = data.password();
        this.document = data.document();
        this.email = data.email();
    }
}
