package dao;

import java.util.List;

import beans.Flower;

public interface FlowerDao {
	List<Flower> queryAll();
	List<Flower> queryAllByPage(int page,int pageSize);
	List<Flower> queryFlowerIndex();
	List<Flower> queryCakeIndex();
	List<Flower> queryLvzhihuahuiIndex();
	List<Flower> queryFlowerAll(int type,int pageSize,int page);
	int queryCount();
	int queryPage(int PageSize);
	int queryFlowerPageSum(int type,int pageSize);
	int deleteOneById(int flowerId);
	int addFlower(Flower fl);
	int updateFlower(Flower fl);
	Flower queryOneByFlowerId(int flowerId);
	Flower queryOneByFlowerIsbn(String flowerIsbn);
}
