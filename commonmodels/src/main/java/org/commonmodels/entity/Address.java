package org.commonmodels.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;
	
	@OneToOne(mappedBy = "address")
	private Student student;

}
