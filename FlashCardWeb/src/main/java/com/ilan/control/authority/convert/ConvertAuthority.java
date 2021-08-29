package com.ilan.control.authority.convert;

import com.ilan.control.authority.Authority;

public interface ConvertAuthority {
	 String toString(Authority authority) ;
	 Authority toAuthority(String authorityStr);
	 Authority getDefaultAuthority() ;
}
