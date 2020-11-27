package com.raphtech.databasejembatank10.service;

import com.raphtech.databasejembatank10.domain.jembatanDomain;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.raphtech.databasejembatank10.dao.jembatanDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author awanlabs
 */
public class jembatanService {

    Connection connection;
    jembatanDao jembatanDao;

    public jembatanService(MysqlDataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
        jembatanDao = new jembatanDao();
        jembatanDao.setConnection(connection);
    }

    public void saveData(jembatanDomain dom) throws SQLException {
        jembatanDao.save(dom);
    }

    public List<jembatanDomain> getAll() throws SQLException {
        return jembatanDao.findAll();
    }

    public List<jembatanDomain> getAllBondowoso() throws SQLException {
        return jembatanDao.findAllBondowoso();
    }

    public List<jembatanDomain> getAllBotolinggo() throws SQLException {
        return jembatanDao.findAllBotolinggo();
    }

    public List<jembatanDomain> getAllCermee() throws SQLException {
        return jembatanDao.findAllCermee();
    }

    public List<jembatanDomain> getAllKlabang() throws SQLException {
        return jembatanDao.findAllKlabang();
    }

    public List<jembatanDomain> getAllPrajekan() throws SQLException {
        return jembatanDao.findAllPrajekan();
    }

    public List<jembatanDomain> getAllPujer() throws SQLException {
        return jembatanDao.findAllPujer();
    }

    public List<jembatanDomain> getAllSukosari() throws SQLException {
        return jembatanDao.findAllSukosari();
    }

    public List<jembatanDomain> getAllIjen() throws SQLException {
        return jembatanDao.findAllIjen();
    }

    public List<jembatanDomain> getAllSumberWringin() throws SQLException {
        return jembatanDao.findAllSumberWringin();
    }

    public List<jembatanDomain> getAllTamanan() throws SQLException {
        return jembatanDao.findAllTamanan();
    }

    public List<jembatanDomain> getAllTapen() throws SQLException {
        return jembatanDao.findAllTapen();
    }

    public List<jembatanDomain> getAllTlogosari() throws SQLException {
        return jembatanDao.findAllTlogosari();
    }

    public List<jembatanDomain> getAllCurahdami() throws SQLException {
        return jembatanDao.findAllCurahdami();
    }

    public List<jembatanDomain> getAllWringin() throws SQLException {
        return jembatanDao.findAllWringin();
    }

    public List<jembatanDomain> getAllPakem() throws SQLException {
        return jembatanDao.findAllPakem();
    }

    public List<jembatanDomain> getAllBinakal() throws SQLException {
        return jembatanDao.findAllBinakal();
    }

    public List<jembatanDomain> getAllTegalampel() throws SQLException {
        return jembatanDao.findAllTegalampel();
    }

    public List<jembatanDomain> getAllTamanKrocok() throws SQLException {
        return jembatanDao.findAllTamanKrocok();
    }

    public List<jembatanDomain> getAllWonosari() throws SQLException {
        return jembatanDao.findAllWonosari();
    }

    public List<jembatanDomain> getAllMaesan() throws SQLException {
        return jembatanDao.findAllMaesan();
    }

    public List<jembatanDomain> getAllTenggarang() throws SQLException {
        return jembatanDao.findAllTenggarang();
    }

    public List<jembatanDomain> getAllGrujugan() throws SQLException {
        return jembatanDao.findAllGrujugan();
    }

    public List<jembatanDomain> getAllJambersari() throws SQLException {
        return jembatanDao.findAllJambesari();
    }

    public void updateData(jembatanDomain dom) throws SQLException {
        jembatanDao.update(dom);
    }

    public jembatanDomain getData(String nama_jbt) throws SQLException {
        return jembatanDao.findOne(nama_jbt);
    }
}
