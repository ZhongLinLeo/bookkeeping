package cn.leo.bookkeeping.assertion;

import cn.leo.bookkeeping.exception.BaseException;
import cn.leo.bookkeeping.response.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * customize assertion
 *
 * @author leo.zl on 2020/5/7
 */
public interface Assert {

    /**
     * 创建异常
     *
     * @return
     */
    BaseException newException();

    /**
     * 创建异常
     *
     * @param monitorMessage 监控信息
     * @return
     */
    BaseException newException(String monitorMessage);

    /**
     * <p>断言对象<code>obj</code>非空。如果对象<code>obj</code>为空，则抛出异常
     *
     * @param obj 待判断对象
     */
    default void assertNotNull(Object obj) {
        if (obj == null) {
            throw newException();
        }
    }

    /**
     * <p>断言对象<code>obj</code>非空。如果对象<code>obj</code>为空，则抛出异常
     * <p>异常信息<code>message</code>支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param obj            待判断对象
     * @param monitorMessage message占位符对应的参数列表
     */
    default void assertNotNull(Object obj, String monitorMessage) {
        if (obj == null) {
            throw newException(monitorMessage);
        }
    }

    /**
     * <p>断言Map<code>map</code>大小不为0。如果Map<code>map</code>大小不为0，则抛出异常
     *
     * @param map 待判断Map
     */
    default void assertNotEmpty(Map<?, ?> map) {
        if (map == null || map.isEmpty()) {
            throw newException();
        }
    }

    /**
     * <p>断言Map<code>map</code>大小不为0。如果Map<code>map</code>大小不为0，则抛出异常
     *
     * @param map            待判断Map
     * @param monitorMessage message占位符对应的参数列表
     */
    default void assertNotEmpty(Map<?, ?> map, String monitorMessage) {
        if (map == null || map.isEmpty()) {
            throw newException(monitorMessage);
        }
    }

    /**
     * <p>断言布尔值<code>expression</code>为false。如果布尔值<code>expression</code>为true，则抛出异常
     *
     * @param expression 待判断布尔变量
     */
    default void assertIsFalse(boolean expression) {
        if (expression) {
            throw newException();
        }
    }

    /**
     * <p>断言布尔值<code>expression</code>为false。如果布尔值<code>expression</code>为true，则抛出异常
     *
     * @param expression     待判断布尔变量
     * @param monitorMessage message占位符对应的参数列表
     */
    default void assertIsFalse(boolean expression, String monitorMessage) {
        if (expression) {
            throw newException(monitorMessage);
        }
    }

    /**
     * <p>断言布尔值<code>expression</code>为true。如果布尔值<code>expression</code>为false，则抛出异常
     *
     * @param expression 待判断布尔变量
     */
    default void assertIsTrue(boolean expression) {
        if (!expression) {
            throw newException();
        }
    }

    /**
     * <p>断言布尔值<code>expression</code>为true。如果布尔值<code>expression</code>为false，则抛出异常
     *
     * @param expression     待判断布尔变量
     * @param monitorMessage message占位符对应的参数列表
     */
    default void assertIsTrue(boolean expression, String monitorMessage) {
        if (!expression) {
            throw newException(monitorMessage);
        }
    }

    /**
     * <p>断言对象<code>obj</code>为<code>null</code>。如果对象<code>obj</code>不为<code>null</code>，则抛出异常
     *
     * @param obj 待判断对象
     */
    default void assertIsNull(Object obj) {
        if (Objects.equals(null, obj)) {
            throw newException();
        }
    }

    /**
     * <p>断言对象<code>obj</code>为<code>null</code>。如果对象<code>obj</code>不为<code>null</code>，则抛出异常
     *
     * @param obj            待判断布尔变量
     * @param monitorMessage message占位符对应的参数列表
     */
    default void assertIsNull(Object obj, String monitorMessage) {
        if (Objects.equals(null, obj)) {
            throw newException(monitorMessage);
        }
    }

    /**
     * <p>断言对象<code>obj</code>为<code>null</code>。如果对象<code>obj</code>不为<code>null</code>，则抛出异常
     *
     * @param obj 待判断对象
     */
    default void assertIsBlank(String obj) {
        if (StringUtils.isBlank(obj)) {
            throw newException();
        }
    }

    /**
     * <p>断言对象<code>obj</code>为<code>null</code>。如果对象<code>obj</code>不为<code>null</code>，则抛出异常
     *
     * @param obj            待判断布尔变量
     * @param monitorMessage message占位符对应的参数列表
     */
    default void assertIsBlank(String obj, String monitorMessage) {
        if (StringUtils.isBlank(obj)) {
            throw newException(monitorMessage);
        }
    }

    /**
     * 断言结果是否有效，如果无效则抛出异常
     *
     * @param result 待判定的结果对象
     */
    default void assertResultInvalid(Result result) {

        if (result == null || !result.isSuccess() || result.getResult() == null) {
            throw newException();
        }
    }

    /**
     * 断言结果是否有效，如果无效则抛出异常
     *
     * @param result         待判定的结果对象
     * @param monitorMessage 监控信息
     */
    default void assertResultInvalid(Result result, String monitorMessage) {
        if (result == null || !result.isSuccess() || result.getResult() == null) {
            throw newException(monitorMessage);
        }
    }

    /**
     * 判断集合是否有效，非null，且长度不为0
     *
     * @param list
     */
    default void assertListEmpty(List list) {
        if (CollectionUtils.isEmpty(list)) {
            throw newException();
        }
    }

    /**
     * 判断集合是否有效，非null，且长度不为0
     *
     * @param list           待判断的list
     * @param monitorMessage message占位符对应的参数列表
     */
    default void assertListEmpty(List list, String monitorMessage) {
        if (CollectionUtils.isEmpty(list)) {
            throw newException(monitorMessage);
        }
    }

}
