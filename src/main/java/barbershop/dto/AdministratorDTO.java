package barbershop.dto;


import barbershop.domain.Administrator;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class AdministratorDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phoneNumber;

    public static AdministratorDTO toDTO(Administrator administrator) {
        return AdministratorDTO.builder()
                .id(administrator.getId())
                .firstName(administrator.getFirstName())
                .lastName(administrator.getLastName())
                .middleName(administrator.getMiddleName())
                .phoneNumber(administrator.getPhoneNumber())
                .build();
    }

}
