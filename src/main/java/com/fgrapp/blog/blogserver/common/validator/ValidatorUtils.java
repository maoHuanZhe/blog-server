package com.fgrapp.blog.blogserver.common.validator;

import com.fgrapp.blog.blogserver.common.exception.MyException;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 参数校验
 *
 * @author FGR on 2019/9/26
 */
public class ValidatorUtils {
    private static Validator validator;

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    /**
     * 校验对象
     * @param object        待校验对象
     * @param groups        待校验的组
     * @throws MyException  校验不通过，则报MyException异常
     */
    public static void validateEntity(Object object, Class<?>... groups)
            throws MyException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            List<String> collect = constraintViolations
                                                    .stream()
                                                    .map(ConstraintViolation::getMessage)
                                                    .collect(Collectors.toList());
            String msg = StringUtils.join(collect, ",");
            throw new MyException(msg);
        }
    }
}
