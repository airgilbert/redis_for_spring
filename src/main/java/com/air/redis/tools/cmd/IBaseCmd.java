package com.air.redis.tools.cmd;

/**
 * 基础命令接口
 * 
 * @author airgilbert
 *
 */
public interface IBaseCmd {
	/**
	 * 
	 * DEL key [key ...]。<br>
	 * 删除给定的一个或多个 key 。<br>
	 * 不存在的 key 会被忽略。
	 * <p>
	 * </p>
	 * 可用版本：
	 * <ul>
	 * <li>= 1.0.0
	 * <li>时间复杂度： O(N)， N 为被删除的 key 的数量。
	 * <li>删除单个字符串类型的 key ，时间复杂度为O(1)。
	 * <li>删除单个列表、集合、有序集合或哈希表类型的 key ，时间复杂度为O(M)， M 为以上数据结构内的元素数量。
	 * </ul>
	 * 
	 * @param keys
	 *            需要删除的keys的集合
	 * @return 被删除 key 的数量。
	 */
	public long del(String... keys);

}
