package com.algaworks.algalog.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente  {

	private Long id;
	private String nome;
	private String email;
	private String telefone;

}
