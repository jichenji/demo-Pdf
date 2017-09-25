package com.chenji.demo.pdf.api.common.aspect;

import com.chenji.demo.pdf.api.common.utils.JsonUtil;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by guiqingqing on 2017/3/15.
 */
public class BaseAspect {
    public List<Object> getParams(Object[] args ){
        return Stream.<Object>of(args).filter(obj->{
            if( obj == null){
                return  true;
            }
            if( !isRecordLog(obj)){
                return false;
            }
            return JsonUtil.objectMapper.canSerialize( obj.getClass());
        }).collect(Collectors.toList());
    }


    protected boolean isRecordLog(Object param){
        if(param instanceof Errors){
            return false;
        }else if(param instanceof HttpServletRequest){
            return false;
        }else if(param instanceof HttpServletResponse){
            return false;
        }else if(param instanceof HttpSession){
            return false;
        }else if(param instanceof Model){
            return false;
        }else if(param instanceof InputStream){
            return false;
        }else if(param instanceof Reader){
            return false;
        }else if(param instanceof OutputStream){
            return false;
        }else if(param instanceof Writer){
            return false;
        }else if(param instanceof Principal){
            return false;
        }else if(param instanceof ModelMap){
            return false;
        }else if(param instanceof RedirectAttributes){
            return false;
        }
        return true;
    }
}