package idusw.leafton.model.entity;

import idusw.leafton.model.DTO.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "member")
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    private Long memberId;

    @OneToOne
    @JoinColumn(name = "styleId" , referencedColumnName = "styleId")
    private Style style;

    @Column
    private String address;

    @Column
    private int zipcode;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private int age;

    @Column
    private int gender;

    @Column
    private String name;

    @Column
    private String phone;



    @Column (columnDefinition = "LONGTEXT")
    private String unity_data;

    //DTO 내의 정보를 현재 객체에 저장하는 메서드
    public static Member toMemberEntity(MemberDTO memberDTO){
        Member member = new Member();
        member.setMemberId(memberDTO.getMemberId());
        member.setStyle(Style.toStyleEntity(memberDTO.getStyleDTO()));
        member.setEmail(memberDTO.getEmail());
        member.setPassword(memberDTO.getPassword());
        member.setAge(memberDTO.getAge());
        member.setGender(memberDTO.getGender());
        member.setName(memberDTO.getName());
        member.setPhone(memberDTO.getPhone());
        member.setUnity_data(memberDTO.getUnity_data());
        member.setZipcode(member.getZipcode());
        return member;

    }
}