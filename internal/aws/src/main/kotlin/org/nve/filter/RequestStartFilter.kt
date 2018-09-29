package org.nve.filter

import org.nve.servlet.AbstractFilter
import javax.inject.Singleton
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse


@Singleton
internal class RequestStartFilter: AbstractFilter() {
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        chain.doFilter(request, response)
    }
}
