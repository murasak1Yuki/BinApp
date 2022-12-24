package ru.shvec.binapp.data.mapper

import ru.shvec.binapp.data.network.model.BinInfoDto
import ru.shvec.binapp.domain.Bank
import ru.shvec.binapp.domain.BinInfo
import ru.shvec.binapp.domain.CardNumber
import ru.shvec.binapp.domain.Country

class BinMapper {

    fun mapDtoToEntity(dto: BinInfoDto) = BinInfo(
        number =  CardNumber(
            luhn = dto.number?.luhn,
            length = dto.number?.length
        ),
        scheme = dto.scheme,
        prepaid = dto.prepaid,
        bank =  Bank(
            phone = dto.bank?.phone,
            city = dto.bank?.city,
            name = dto.bank?.name,
            url = dto.bank?.url
        ),
        brand = dto.brand,
        country = Country(
            emoji = dto.country?.emoji,
            name = dto.country?.name,
            longitude = dto.country?.longitude,
            latitude = dto.country?.latitude,
            currency = dto.country?.currency,
            alpha2 = dto.country?.alpha2,
            numeric = dto.country?.numeric
        ),
        type = dto.type
    )
}