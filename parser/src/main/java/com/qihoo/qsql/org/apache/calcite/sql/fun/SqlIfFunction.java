package com.qihoo.qsql.org.apache.calcite.sql.fun;

import com.qihoo.qsql.org.apache.calcite.sql.*;
import com.qihoo.qsql.org.apache.calcite.sql.type.InferTypes;
import com.qihoo.qsql.org.apache.calcite.sql.type.OperandTypes;
import com.qihoo.qsql.org.apache.calcite.sql.type.ReturnTypes;
import com.qihoo.qsql.org.apache.calcite.sql.type.SqlOperandCountRanges;
import com.qihoo.qsql.org.apache.calcite.sql.validate.SqlMonotonicity;

import java.util.List;

public class SqlIfFunction extends SqlFunction {
    public SqlIfFunction() {
        super("IF",
            SqlKind.OTHER_FUNCTION,
            ReturnTypes.ARG1_NULLABLE,
            InferTypes.RETURN_TYPE,
            null,
            SqlFunctionCategory.STRING);
    }

    @Override
    public boolean checkOperandTypes(
        SqlCallBinding callBinding,
        boolean throwOnFailure
    ) {
        final List<SqlNode> operands = callBinding.operands();
        int n = operands.size();
        assert (3 == n);
        //TODO add type checker
        return OperandTypes.BOOLEAN.checkSingleOperandType(
                callBinding, operands.get(0), 0, throwOnFailure);
    }

    @Override
    public SqlOperandCountRange getOperandCountRange() {
        return SqlOperandCountRanges.between(3, 3);
    }

    @Override public SqlMonotonicity getMonotonicity(SqlOperatorBinding call) {
        return SqlMonotonicity.INCREASING;
    }
}