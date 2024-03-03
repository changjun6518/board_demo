package com.jj.demo.member;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    MemberDto memberToMemberDto(Member member);
    Member memberDtoToMember(MemberDto memberDto);

    void update(@MappingTarget Member member, MemberDto memberDto);

}
