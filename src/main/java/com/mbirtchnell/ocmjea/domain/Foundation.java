package com.mbirtchnell.ocmjea.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Foundation extends Component
{
	@Id @GeneratedValue private int id;
}
