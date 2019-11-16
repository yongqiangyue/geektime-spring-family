package geektime.spring.data.declarativetransactiondemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class FooServiceImpl implements FooService {
    @Autowired
    private FooService fooService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void insertRecord() {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('AAA')");
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class, propagation = Propagation.NESTED)
    public void insertThenRollback() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('BBB')");
        throw new RollbackException();
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void invokeInsertThenRollback() throws RollbackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('AAA')");
        try{
            fooService.insertThenRollback();
        } catch (RollbackException e){
//            log.error("RollbackException", e);
//            e.printStackTrace();
        }
//        throw new RollbackException();
    }

    @Override
    public void invokeInsertThenRollbackBySelfService() throws RollbackException {
        fooService.insertThenRollback();
    }

    @Override
    public void invokeInsertThenRollbackByAopContext() throws RollbackException {
        ((FooService)(AopContext.currentProxy())).insertThenRollback();
    }

    @Transactional(rollbackFor = RollbackException.class)
    @Override
    public void invokeInsertThenRollbackAddTransactional() throws RollbackException {
        insertThenRollback();
    }
}
