package com.itwill.ilhajob.corp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.itwill.ilhajob.user.entity.App;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(name = "recruit_id_SEQ_gen",
				   sequenceName = "recruit_id_SEQ",
				   allocationSize = 1)
@Table(name = "recruit")
public class Recruit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recruit_id_SEQ_gen")
	private Long id;
	
	@NonNull
	@Column(nullable = false, length = 600)
	private String rcTitle; 
	
	private String rcPosition;
	
	@NonNull
	@Column(nullable = false, length = 1000)
	private String rcContent;
	
	private String rcQualification;
	
	private int rcSalary;
	
	private Date rcDate;
	
	@NonNull
	private Date rcDeadline;
	
	@Column(columnDefinition = "NUMBER(19) DEFAULT 0")
	private int rcReadCount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "corp_id")
	@ToString.Exclude
	private Corp corp;
	
	@OneToMany(mappedBy = "recruit",
			   cascade = CascadeType.ALL)
	private List<App> appList = new ArrayList<App>();
}

