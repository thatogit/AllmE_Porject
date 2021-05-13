package com.villascode.allme.registration.token;

import com.villascode.allme.appuser.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

    @Id
    @SequenceGenerator(
            name = "token_confirmation_sequnce",
            sequenceName = "token_confirmation_sequnce",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "token_confirmation_sequnce"
    )
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createOn;

    @Column(nullable = false)
    private LocalDateTime expiresOn;

    private LocalDateTime confirmedOn;

    @ManyToOne
    @JoinColumn(nullable = false,
    name="app_user_id")
    private AppUser appUser;

    public ConfirmationToken(String token, LocalDateTime createOn, LocalDateTime expiredOn,AppUser appUser) {
        this.token = token;
        this.createOn = createOn;
        this.expiresOn = expiredOn;
        this.appUser=appUser;
    }
}
