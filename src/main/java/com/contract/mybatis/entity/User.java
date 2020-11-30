package com.contract.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Host
     *
     * @mbggenerated
     */
    private String host;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.User
     *
     * @mbggenerated
     */
    private String user;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Select_priv
     *
     * @mbggenerated
     */
    private String selectPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Insert_priv
     *
     * @mbggenerated
     */
    private String insertPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Update_priv
     *
     * @mbggenerated
     */
    private String updatePriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Delete_priv
     *
     * @mbggenerated
     */
    private String deletePriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Create_priv
     *
     * @mbggenerated
     */
    private String createPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Drop_priv
     *
     * @mbggenerated
     */
    private String dropPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Reload_priv
     *
     * @mbggenerated
     */
    private String reloadPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Shutdown_priv
     *
     * @mbggenerated
     */
    private String shutdownPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Process_priv
     *
     * @mbggenerated
     */
    private String processPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.File_priv
     *
     * @mbggenerated
     */
    private String filePriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Grant_priv
     *
     * @mbggenerated
     */
    private String grantPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.References_priv
     *
     * @mbggenerated
     */
    private String referencesPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Index_priv
     *
     * @mbggenerated
     */
    private String indexPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Alter_priv
     *
     * @mbggenerated
     */
    private String alterPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Show_db_priv
     *
     * @mbggenerated
     */
    private String showDbPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Super_priv
     *
     * @mbggenerated
     */
    private String superPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Create_tmp_table_priv
     *
     * @mbggenerated
     */
    private String createTmpTablePriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Lock_tables_priv
     *
     * @mbggenerated
     */
    private String lockTablesPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Execute_priv
     *
     * @mbggenerated
     */
    private String executePriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Repl_slave_priv
     *
     * @mbggenerated
     */
    private String replSlavePriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Repl_client_priv
     *
     * @mbggenerated
     */
    private String replClientPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Create_view_priv
     *
     * @mbggenerated
     */
    private String createViewPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Show_view_priv
     *
     * @mbggenerated
     */
    private String showViewPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Create_routine_priv
     *
     * @mbggenerated
     */
    private String createRoutinePriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Alter_routine_priv
     *
     * @mbggenerated
     */
    private String alterRoutinePriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Create_user_priv
     *
     * @mbggenerated
     */
    private String createUserPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Event_priv
     *
     * @mbggenerated
     */
    private String eventPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Trigger_priv
     *
     * @mbggenerated
     */
    private String triggerPriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.Create_tablespace_priv
     *
     * @mbggenerated
     */
    private String createTablespacePriv;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.ssl_type
     *
     * @mbggenerated
     */
    private String sslType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.max_questions
     *
     * @mbggenerated
     */
    private Integer maxQuestions;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.max_updates
     *
     * @mbggenerated
     */
    private Integer maxUpdates;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.max_connections
     *
     * @mbggenerated
     */
    private Integer maxConnections;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.max_user_connections
     *
     * @mbggenerated
     */
    private Integer maxUserConnections;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.plugin
     *
     * @mbggenerated
     */
    private String plugin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password_expired
     *
     * @mbggenerated
     */
    private String passwordExpired;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password_last_changed
     *
     * @mbggenerated
     */
    private Date passwordLastChanged;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password_lifetime
     *
     * @mbggenerated
     */
    private Short passwordLifetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.account_locked
     *
     * @mbggenerated
     */
    private String accountLocked;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Host
     *
     * @return the value of user.Host
     *
     * @mbggenerated
     */
    public String getHost() {
        return host;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Host
     *
     * @param host the value for user.Host
     *
     * @mbggenerated
     */
    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.User
     *
     * @return the value of user.User
     *
     * @mbggenerated
     */
    public String getUser() {
        return user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.User
     *
     * @param user the value for user.User
     *
     * @mbggenerated
     */
    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Select_priv
     *
     * @return the value of user.Select_priv
     *
     * @mbggenerated
     */
    public String getSelectPriv() {
        return selectPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Select_priv
     *
     * @param selectPriv the value for user.Select_priv
     *
     * @mbggenerated
     */
    public void setSelectPriv(String selectPriv) {
        this.selectPriv = selectPriv == null ? null : selectPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Insert_priv
     *
     * @return the value of user.Insert_priv
     *
     * @mbggenerated
     */
    public String getInsertPriv() {
        return insertPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Insert_priv
     *
     * @param insertPriv the value for user.Insert_priv
     *
     * @mbggenerated
     */
    public void setInsertPriv(String insertPriv) {
        this.insertPriv = insertPriv == null ? null : insertPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Update_priv
     *
     * @return the value of user.Update_priv
     *
     * @mbggenerated
     */
    public String getUpdatePriv() {
        return updatePriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Update_priv
     *
     * @param updatePriv the value for user.Update_priv
     *
     * @mbggenerated
     */
    public void setUpdatePriv(String updatePriv) {
        this.updatePriv = updatePriv == null ? null : updatePriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Delete_priv
     *
     * @return the value of user.Delete_priv
     *
     * @mbggenerated
     */
    public String getDeletePriv() {
        return deletePriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Delete_priv
     *
     * @param deletePriv the value for user.Delete_priv
     *
     * @mbggenerated
     */
    public void setDeletePriv(String deletePriv) {
        this.deletePriv = deletePriv == null ? null : deletePriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Create_priv
     *
     * @return the value of user.Create_priv
     *
     * @mbggenerated
     */
    public String getCreatePriv() {
        return createPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Create_priv
     *
     * @param createPriv the value for user.Create_priv
     *
     * @mbggenerated
     */
    public void setCreatePriv(String createPriv) {
        this.createPriv = createPriv == null ? null : createPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Drop_priv
     *
     * @return the value of user.Drop_priv
     *
     * @mbggenerated
     */
    public String getDropPriv() {
        return dropPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Drop_priv
     *
     * @param dropPriv the value for user.Drop_priv
     *
     * @mbggenerated
     */
    public void setDropPriv(String dropPriv) {
        this.dropPriv = dropPriv == null ? null : dropPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Reload_priv
     *
     * @return the value of user.Reload_priv
     *
     * @mbggenerated
     */
    public String getReloadPriv() {
        return reloadPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Reload_priv
     *
     * @param reloadPriv the value for user.Reload_priv
     *
     * @mbggenerated
     */
    public void setReloadPriv(String reloadPriv) {
        this.reloadPriv = reloadPriv == null ? null : reloadPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Shutdown_priv
     *
     * @return the value of user.Shutdown_priv
     *
     * @mbggenerated
     */
    public String getShutdownPriv() {
        return shutdownPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Shutdown_priv
     *
     * @param shutdownPriv the value for user.Shutdown_priv
     *
     * @mbggenerated
     */
    public void setShutdownPriv(String shutdownPriv) {
        this.shutdownPriv = shutdownPriv == null ? null : shutdownPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Process_priv
     *
     * @return the value of user.Process_priv
     *
     * @mbggenerated
     */
    public String getProcessPriv() {
        return processPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Process_priv
     *
     * @param processPriv the value for user.Process_priv
     *
     * @mbggenerated
     */
    public void setProcessPriv(String processPriv) {
        this.processPriv = processPriv == null ? null : processPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.File_priv
     *
     * @return the value of user.File_priv
     *
     * @mbggenerated
     */
    public String getFilePriv() {
        return filePriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.File_priv
     *
     * @param filePriv the value for user.File_priv
     *
     * @mbggenerated
     */
    public void setFilePriv(String filePriv) {
        this.filePriv = filePriv == null ? null : filePriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Grant_priv
     *
     * @return the value of user.Grant_priv
     *
     * @mbggenerated
     */
    public String getGrantPriv() {
        return grantPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Grant_priv
     *
     * @param grantPriv the value for user.Grant_priv
     *
     * @mbggenerated
     */
    public void setGrantPriv(String grantPriv) {
        this.grantPriv = grantPriv == null ? null : grantPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.References_priv
     *
     * @return the value of user.References_priv
     *
     * @mbggenerated
     */
    public String getReferencesPriv() {
        return referencesPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.References_priv
     *
     * @param referencesPriv the value for user.References_priv
     *
     * @mbggenerated
     */
    public void setReferencesPriv(String referencesPriv) {
        this.referencesPriv = referencesPriv == null ? null : referencesPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Index_priv
     *
     * @return the value of user.Index_priv
     *
     * @mbggenerated
     */
    public String getIndexPriv() {
        return indexPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Index_priv
     *
     * @param indexPriv the value for user.Index_priv
     *
     * @mbggenerated
     */
    public void setIndexPriv(String indexPriv) {
        this.indexPriv = indexPriv == null ? null : indexPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Alter_priv
     *
     * @return the value of user.Alter_priv
     *
     * @mbggenerated
     */
    public String getAlterPriv() {
        return alterPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Alter_priv
     *
     * @param alterPriv the value for user.Alter_priv
     *
     * @mbggenerated
     */
    public void setAlterPriv(String alterPriv) {
        this.alterPriv = alterPriv == null ? null : alterPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Show_db_priv
     *
     * @return the value of user.Show_db_priv
     *
     * @mbggenerated
     */
    public String getShowDbPriv() {
        return showDbPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Show_db_priv
     *
     * @param showDbPriv the value for user.Show_db_priv
     *
     * @mbggenerated
     */
    public void setShowDbPriv(String showDbPriv) {
        this.showDbPriv = showDbPriv == null ? null : showDbPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Super_priv
     *
     * @return the value of user.Super_priv
     *
     * @mbggenerated
     */
    public String getSuperPriv() {
        return superPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Super_priv
     *
     * @param superPriv the value for user.Super_priv
     *
     * @mbggenerated
     */
    public void setSuperPriv(String superPriv) {
        this.superPriv = superPriv == null ? null : superPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Create_tmp_table_priv
     *
     * @return the value of user.Create_tmp_table_priv
     *
     * @mbggenerated
     */
    public String getCreateTmpTablePriv() {
        return createTmpTablePriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Create_tmp_table_priv
     *
     * @param createTmpTablePriv the value for user.Create_tmp_table_priv
     *
     * @mbggenerated
     */
    public void setCreateTmpTablePriv(String createTmpTablePriv) {
        this.createTmpTablePriv = createTmpTablePriv == null ? null : createTmpTablePriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Lock_tables_priv
     *
     * @return the value of user.Lock_tables_priv
     *
     * @mbggenerated
     */
    public String getLockTablesPriv() {
        return lockTablesPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Lock_tables_priv
     *
     * @param lockTablesPriv the value for user.Lock_tables_priv
     *
     * @mbggenerated
     */
    public void setLockTablesPriv(String lockTablesPriv) {
        this.lockTablesPriv = lockTablesPriv == null ? null : lockTablesPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Execute_priv
     *
     * @return the value of user.Execute_priv
     *
     * @mbggenerated
     */
    public String getExecutePriv() {
        return executePriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Execute_priv
     *
     * @param executePriv the value for user.Execute_priv
     *
     * @mbggenerated
     */
    public void setExecutePriv(String executePriv) {
        this.executePriv = executePriv == null ? null : executePriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Repl_slave_priv
     *
     * @return the value of user.Repl_slave_priv
     *
     * @mbggenerated
     */
    public String getReplSlavePriv() {
        return replSlavePriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Repl_slave_priv
     *
     * @param replSlavePriv the value for user.Repl_slave_priv
     *
     * @mbggenerated
     */
    public void setReplSlavePriv(String replSlavePriv) {
        this.replSlavePriv = replSlavePriv == null ? null : replSlavePriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Repl_client_priv
     *
     * @return the value of user.Repl_client_priv
     *
     * @mbggenerated
     */
    public String getReplClientPriv() {
        return replClientPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Repl_client_priv
     *
     * @param replClientPriv the value for user.Repl_client_priv
     *
     * @mbggenerated
     */
    public void setReplClientPriv(String replClientPriv) {
        this.replClientPriv = replClientPriv == null ? null : replClientPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Create_view_priv
     *
     * @return the value of user.Create_view_priv
     *
     * @mbggenerated
     */
    public String getCreateViewPriv() {
        return createViewPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Create_view_priv
     *
     * @param createViewPriv the value for user.Create_view_priv
     *
     * @mbggenerated
     */
    public void setCreateViewPriv(String createViewPriv) {
        this.createViewPriv = createViewPriv == null ? null : createViewPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Show_view_priv
     *
     * @return the value of user.Show_view_priv
     *
     * @mbggenerated
     */
    public String getShowViewPriv() {
        return showViewPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Show_view_priv
     *
     * @param showViewPriv the value for user.Show_view_priv
     *
     * @mbggenerated
     */
    public void setShowViewPriv(String showViewPriv) {
        this.showViewPriv = showViewPriv == null ? null : showViewPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Create_routine_priv
     *
     * @return the value of user.Create_routine_priv
     *
     * @mbggenerated
     */
    public String getCreateRoutinePriv() {
        return createRoutinePriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Create_routine_priv
     *
     * @param createRoutinePriv the value for user.Create_routine_priv
     *
     * @mbggenerated
     */
    public void setCreateRoutinePriv(String createRoutinePriv) {
        this.createRoutinePriv = createRoutinePriv == null ? null : createRoutinePriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Alter_routine_priv
     *
     * @return the value of user.Alter_routine_priv
     *
     * @mbggenerated
     */
    public String getAlterRoutinePriv() {
        return alterRoutinePriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Alter_routine_priv
     *
     * @param alterRoutinePriv the value for user.Alter_routine_priv
     *
     * @mbggenerated
     */
    public void setAlterRoutinePriv(String alterRoutinePriv) {
        this.alterRoutinePriv = alterRoutinePriv == null ? null : alterRoutinePriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Create_user_priv
     *
     * @return the value of user.Create_user_priv
     *
     * @mbggenerated
     */
    public String getCreateUserPriv() {
        return createUserPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Create_user_priv
     *
     * @param createUserPriv the value for user.Create_user_priv
     *
     * @mbggenerated
     */
    public void setCreateUserPriv(String createUserPriv) {
        this.createUserPriv = createUserPriv == null ? null : createUserPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Event_priv
     *
     * @return the value of user.Event_priv
     *
     * @mbggenerated
     */
    public String getEventPriv() {
        return eventPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Event_priv
     *
     * @param eventPriv the value for user.Event_priv
     *
     * @mbggenerated
     */
    public void setEventPriv(String eventPriv) {
        this.eventPriv = eventPriv == null ? null : eventPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Trigger_priv
     *
     * @return the value of user.Trigger_priv
     *
     * @mbggenerated
     */
    public String getTriggerPriv() {
        return triggerPriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Trigger_priv
     *
     * @param triggerPriv the value for user.Trigger_priv
     *
     * @mbggenerated
     */
    public void setTriggerPriv(String triggerPriv) {
        this.triggerPriv = triggerPriv == null ? null : triggerPriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.Create_tablespace_priv
     *
     * @return the value of user.Create_tablespace_priv
     *
     * @mbggenerated
     */
    public String getCreateTablespacePriv() {
        return createTablespacePriv;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.Create_tablespace_priv
     *
     * @param createTablespacePriv the value for user.Create_tablespace_priv
     *
     * @mbggenerated
     */
    public void setCreateTablespacePriv(String createTablespacePriv) {
        this.createTablespacePriv = createTablespacePriv == null ? null : createTablespacePriv.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.ssl_type
     *
     * @return the value of user.ssl_type
     *
     * @mbggenerated
     */
    public String getSslType() {
        return sslType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.ssl_type
     *
     * @param sslType the value for user.ssl_type
     *
     * @mbggenerated
     */
    public void setSslType(String sslType) {
        this.sslType = sslType == null ? null : sslType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.max_questions
     *
     * @return the value of user.max_questions
     *
     * @mbggenerated
     */
    public Integer getMaxQuestions() {
        return maxQuestions;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.max_questions
     *
     * @param maxQuestions the value for user.max_questions
     *
     * @mbggenerated
     */
    public void setMaxQuestions(Integer maxQuestions) {
        this.maxQuestions = maxQuestions;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.max_updates
     *
     * @return the value of user.max_updates
     *
     * @mbggenerated
     */
    public Integer getMaxUpdates() {
        return maxUpdates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.max_updates
     *
     * @param maxUpdates the value for user.max_updates
     *
     * @mbggenerated
     */
    public void setMaxUpdates(Integer maxUpdates) {
        this.maxUpdates = maxUpdates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.max_connections
     *
     * @return the value of user.max_connections
     *
     * @mbggenerated
     */
    public Integer getMaxConnections() {
        return maxConnections;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.max_connections
     *
     * @param maxConnections the value for user.max_connections
     *
     * @mbggenerated
     */
    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.max_user_connections
     *
     * @return the value of user.max_user_connections
     *
     * @mbggenerated
     */
    public Integer getMaxUserConnections() {
        return maxUserConnections;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.max_user_connections
     *
     * @param maxUserConnections the value for user.max_user_connections
     *
     * @mbggenerated
     */
    public void setMaxUserConnections(Integer maxUserConnections) {
        this.maxUserConnections = maxUserConnections;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.plugin
     *
     * @return the value of user.plugin
     *
     * @mbggenerated
     */
    public String getPlugin() {
        return plugin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.plugin
     *
     * @param plugin the value for user.plugin
     *
     * @mbggenerated
     */
    public void setPlugin(String plugin) {
        this.plugin = plugin == null ? null : plugin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password_expired
     *
     * @return the value of user.password_expired
     *
     * @mbggenerated
     */
    public String getPasswordExpired() {
        return passwordExpired;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password_expired
     *
     * @param passwordExpired the value for user.password_expired
     *
     * @mbggenerated
     */
    public void setPasswordExpired(String passwordExpired) {
        this.passwordExpired = passwordExpired == null ? null : passwordExpired.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password_last_changed
     *
     * @return the value of user.password_last_changed
     *
     * @mbggenerated
     */
    public Date getPasswordLastChanged() {
        return passwordLastChanged;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password_last_changed
     *
     * @param passwordLastChanged the value for user.password_last_changed
     *
     * @mbggenerated
     */
    public void setPasswordLastChanged(Date passwordLastChanged) {
        this.passwordLastChanged = passwordLastChanged;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password_lifetime
     *
     * @return the value of user.password_lifetime
     *
     * @mbggenerated
     */
    public Short getPasswordLifetime() {
        return passwordLifetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password_lifetime
     *
     * @param passwordLifetime the value for user.password_lifetime
     *
     * @mbggenerated
     */
    public void setPasswordLifetime(Short passwordLifetime) {
        this.passwordLifetime = passwordLifetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.account_locked
     *
     * @return the value of user.account_locked
     *
     * @mbggenerated
     */
    public String getAccountLocked() {
        return accountLocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.account_locked
     *
     * @param accountLocked the value for user.account_locked
     *
     * @mbggenerated
     */
    public void setAccountLocked(String accountLocked) {
        this.accountLocked = accountLocked == null ? null : accountLocked.trim();
    }
}