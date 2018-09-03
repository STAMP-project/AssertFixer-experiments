package org.nve.servlet

import javax.servlet.*

abstract class AbstractFilter: Filter {
    protected lateinit var filterConfig: FilterConfig

    override fun init(filterConfig: FilterConfig) {
        this.filterConfig = filterConfig
    }

    abstract override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain)

    override fun destroy() {}
}
