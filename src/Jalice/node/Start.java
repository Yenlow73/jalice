/* This file was generated by SableCC (http://www.sablecc.org/). */

package Jalice.node;

import Jalice.analysis.*;

@SuppressWarnings("nls")
public final class Start extends Node
{
    private PGramatica _pGramatica_;
    private EOF _eof_;

    public Start()
    {
        // Empty body
    }

    public Start(
        @SuppressWarnings("hiding") PGramatica _pGramatica_,
        @SuppressWarnings("hiding") EOF _eof_)
    {
        setPGramatica(_pGramatica_);
        setEOF(_eof_);
    }

    @Override
    public Object clone()
    {
        return new Start(
            cloneNode(this._pGramatica_),
            cloneNode(this._eof_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseStart(this);
    }

    public PGramatica getPGramatica()
    {
        return this._pGramatica_;
    }

    public void setPGramatica(PGramatica node)
    {
        if(this._pGramatica_ != null)
        {
            this._pGramatica_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pGramatica_ = node;
    }

    public EOF getEOF()
    {
        return this._eof_;
    }

    public void setEOF(EOF node)
    {
        if(this._eof_ != null)
        {
            this._eof_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._eof_ = node;
    }

    @Override
    void removeChild(Node child)
    {
        if(this._pGramatica_ == child)
        {
            this._pGramatica_ = null;
            return;
        }

        if(this._eof_ == child)
        {
            this._eof_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(Node oldChild, Node newChild)
    {
        if(this._pGramatica_ == oldChild)
        {
            setPGramatica((PGramatica) newChild);
            return;
        }

        if(this._eof_ == oldChild)
        {
            setEOF((EOF) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    public String toString()
    {
        return "" +
            toString(this._pGramatica_) +
            toString(this._eof_);
    }
}
