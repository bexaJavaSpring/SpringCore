package com.example.springcore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@AllArgsConstructor  // -->> Hamma constructorlarni yaratish
@NoArgsConstructor   // -->> bo'sh constructor yaratish annotatsiya bilan'
@Data                // -->> @Getter, @Setter va @ToString annotasiyalarni birlashmasi
//@Getter             // -->> getter methodlarni yaratish
//@Setter             // -->> setter methodlarni yaratish
@Entity             // -->> Class ni bean qiladi va shu class ni database table ga o'giradi
@Table(name = "students")             // -->> database dagi table nomini custom qilib yozsa bo'ladi
@FieldDefaults(level = AccessLevel.PRIVATE)  // -->> shu class dagi barcha field larni private qiladi
@Builder
public class Student {
    @Id        // -->> shu class yani table ni id sini primary key qiladi
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // -->> id ni ozi generatsiya qiladi, sequence yozib boradi
    Integer id;

    @Column(name = "first_name", nullable = false, unique = true, length = 20) // -->> bu anotatsiya shu field ni bazi
    // bir sozlamalarini qiladi, masalan nullable = false -> shu field null bo'la olmaydi
    // check constraint yozdik hisob
    String firstName;

    @Column(name = "last_name")
    String lastName;

    String email;
    @Column(name = "middle_name")
    String middleName;

    @Max(60)
    @Min(1)
    Integer age;

    @ManyToOne(fetch = FetchType.LAZY) //-->> bu shu field bilan boglanishni taminlaydi yani bu yerda ko'p student
    // bitta fakultetga bog'liq deyilyapti
    @JoinColumn(name = "faculty_id", nullable = false, referencedColumnName = "id")  // -->> bu @Column anotatsiya
    // ichida qanaqa sozlamalar qilsak bunda ham qilsa bo'lsa va shu field
    // bilan boglanish hosil qiladi va qaysidir column bilan va yana foreing key hosil qip beradi, check constraint lar ham qiladi
    Faculty faculty;


//    @ManyToOne(fetch = FetchType.EAGER)  biderictional davomi
//    Faculty faculty;

//    faculty table parent
//    student - child

}
