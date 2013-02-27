package org.springframework.security.oauth.examples.tonr;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//This class is needed to insert three filters between two named positions, where normally only two filters can be inserted
public class MultipleFilterWrapper implements Filter {

	private List<Filter> filterList;

	public void doFilter(ServletRequest request, ServletResponse response, final FilterChain chain) throws IOException,
			ServletException {
		// TODO can we just add chain instead of this wrapping class?
		FilterChain filterChain = new FilterChain() {

			public void doFilter(ServletRequest arg0, ServletResponse arg1) throws IOException, ServletException {
				chain.doFilter(arg0, arg1);
			}
		};
		Vector<FilterChain> filterChains = new Vector<FilterChain>();
		filterChains.add(filterChain);

		for (final Filter filter : filterList) {
			final FilterChain lastChain = filterChains.lastElement();
			FilterChain loopChain = new FilterChain() {

				public void doFilter(ServletRequest arg0, ServletResponse arg1) throws IOException, ServletException
				{
					filter.doFilter(arg0, arg1, lastChain);
				}
			};
			filterChains.add(loopChain);
		}
		filterChains.lastElement().doFilter(request, response);
	}

	public void setFilterList(List<Filter> filterList)
	{
		this.filterList = filterList;
		Collections.reverse(this.filterList);
	}

	public void destroy() {
		// nothing

	}

	public void init(FilterConfig arg0) throws ServletException {
		// nothing
	}

}