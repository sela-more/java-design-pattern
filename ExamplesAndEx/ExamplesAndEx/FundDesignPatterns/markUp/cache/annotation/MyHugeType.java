package markUp.cache.annotation;



@CacheableAnnotation(isMarked = true)
class MyHugeType extends Object 
{
  private double Data[][];
  MyHugeType()
  {
    Data = new double[500][500];
    for (double d1 = 0 ; d1 < Data.length ; ++d1)
      for (double d2 = 0 ; d2 < Data[0].length ; ++d2)
        Data[(int)d1][(int)d2] = d1 * d2;
  }
}
