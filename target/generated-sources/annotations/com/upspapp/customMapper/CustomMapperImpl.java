package com.upspapp.customMapper;

import com.upspapp.modal.Buyer;
import com.upspapp.modal.Seller;
import com.upspapp.modal.User;
import com.upspapp.requestDto.UserDto;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-20T22:18:41-0500",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230413-0857, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class CustomMapperImpl implements CustomMapper {

    @Override
    public User userDtoToUser(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setProfileImage( dto.getProfileImage() );
        user.setEmail( dto.getEmail() );
        user.setActive( dto.getActive() );
        user.setPassword( dto.getPassword() );
        user.setMobileNumber( dto.getMobileNumber() );
        user.setFullName( dto.getFullName() );

        return user;
    }

    @Override
    public Buyer userDtoToBuyer(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        Buyer buyer = new Buyer();

        buyer.setProfileImage( userDto.getProfileImage() );
        buyer.setEmail( userDto.getEmail() );
        buyer.setActive( userDto.getActive() );
        buyer.setPassword( userDto.getPassword() );
        buyer.setMobileNumber( userDto.getMobileNumber() );
        buyer.setFullName( userDto.getFullName() );

        return buyer;
    }

    @Override
    public Seller userDtoToSeller(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        Seller seller = new Seller();

        seller.setProfileImage( dto.getProfileImage() );
        seller.setEmail( dto.getEmail() );
        seller.setActive( dto.getActive() );
        seller.setPassword( dto.getPassword() );
        seller.setMobileNumber( dto.getMobileNumber() );
        seller.setFullName( dto.getFullName() );

        return seller;
    }
}
