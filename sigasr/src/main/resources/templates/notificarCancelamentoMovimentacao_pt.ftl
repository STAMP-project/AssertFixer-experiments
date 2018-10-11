<html>
	<body>
		<p>
			Informamos que foi <b>cancelada</b>, em
			${(movimentacao.movCanceladora.dtIniMovDDMMYYYYHHMM)!}, a <b>movimentação</b> de ${(movimentacao.tipoMov.nome)!},
			dada na solicitação <b>${sol.codigo}</b>
		</p>
		<blockquote>
			<p style="text-decoration: line-through;">${(movimentacao.descrMovimentacao)!}</p>
			<p>
				<b>Cancelada</b> por
				${(movimentacao.movCanceladora.cadastrante.descricaoIniciaisMaiusculas)!}
				(${(movimentacao.movCanceladora.lotaCadastrante.siglaLotacao)!})
			</p>
			<p>Movimentação havia sido realizada por
				${(movimentacao.cadastrante.descricaoIniciaisMaiusculas)!}
				(${(movimentacao.lotaCadastrante.siglaLotacao)!})
			</p>
		</blockquote>
		<p>
			Para acessar a solicitação, clique <a href="${link}">aqui</a>.
		</p>
	</body>
</html>