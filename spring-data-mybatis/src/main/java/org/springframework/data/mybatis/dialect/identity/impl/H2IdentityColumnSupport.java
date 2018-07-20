package org.springframework.data.mybatis.dialect.identity.impl;

public class H2IdentityColumnSupport extends IdentityColumnSupportImpl {

	@Override
	public boolean supportsIdentityColumns() {
		return true;
	}

	@Override
	public String getIdentityColumnString(int type) {
		// not null is implicit
		return "generated by default as identity";
	}

	@Override
	public String getIdentitySelectString(String table, String column, int type) {
		return "call identity()";
	}

	@Override
	public String getIdentityInsertString() {
		return "null";
	}

}
