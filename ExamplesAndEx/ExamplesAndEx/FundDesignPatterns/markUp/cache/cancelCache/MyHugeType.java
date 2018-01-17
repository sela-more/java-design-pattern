package markUp.cache.cancelCache;
class MyHugeType extends Object implements Cacheable
{
  private double Data[][];
  MyHugeType()
  {
    Data = new double[400][400];
    for (double d1 = 0 ; d1 < Data.length ; ++d1)
      for (double d2 = 0 ; d2 < Data[0].length ; ++d2)
        Data[(int)d1][(int)d2] = d1 * d2;
  }
}
