package io.github.caiwan.utils;

import lombok.*;

/**
 * @author caiwan
 * Defines a pair tuple of data
 * @param <L> first tpye (left)
 * @param <R> second type (right)
 */

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Pair<L, R> {
	private L left;
	private R right;
}
